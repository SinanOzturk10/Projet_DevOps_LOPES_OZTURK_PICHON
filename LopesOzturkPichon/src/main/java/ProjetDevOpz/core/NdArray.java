package ProjetDevOpz.core;

import ProjetDevOpz.factory.NdArrayFactory;
import ProjetDevOpz.utils.NdArrayPrinter;

// we define an abstract class instead of an interface
// because 1D and 2D vectors share the same attributes.
// They also share some functions because of the structure
// of our NdArray which defines any vector in a 1D plane 
// vector coupled with a shape.
// with an interface we would not be able to ensure the
// child classes share same methods and attributes
public abstract class NdArray {

    // internal storage
	// data is the raw content of the structure
	// shape is the form of the vector
	//
	// for instance in python 
	// a = np.array([1,2,3])
	// has dimension (3,)
	// b = np.array([[1,2,3],[5,6,7]])
	// has dimension (2, 3)
	// because b contains 2 elements in which there are 3 elements
	// d = array([
	//				[[1, 2, 3],
	// 				[4, 5, 6],
	//		       	[7, 8, 9]],
	//
	//       		[[1, 2, 3],
	//        		[4, 5, 6],
	//        		[7, 8, 9]]	
	//							])
	// has dimension (2, 3, 3)
	// because it contains 2 elements in which there are 3 elements with 3 other elements
	// anyway shape is nothing more than an exploration of the array
    protected float[] data;
    protected int[] shape;

    // numpy attributes
    // ndim is the number of dimension 1D, 2D, ... ND (in our case only 1D and 2D are mandatory)
    // size is the number of elements in the array
    // see the docs if you want add more attributes https://numpy.org/doc/stable/reference/arrays.ndarray.html
    public final int ndim;
    public final int size;

    // constructor
    // data and shape arguments are sufficent to define all vectors in 1D and 2D
    // then we fill other properties of the vector
    // where ndim and size are both derived attributes
    protected NdArray(float[] data, int[] shape) {
        this.data  = data;
        this.shape = shape;
        this.ndim  = shape.length;
        this.size  = computeSize(shape);
    }

    // mandatory operations (5.1)
    // those methods will be implemented differently
    // depending to whether 1D or 2D. this is why
    // methods are abstract and need to be implemented
    // in specified sub-classes.
    public abstract NdArray add(NdArray other);   // returns new object (equivalent to '+' operation)
    public abstract void iadd(NdArray other);  // modify in place (equivalent to '+=' operation)

    // reshape (5.1)
    // if the data cannot fit
    // in the new given shape
    // we return an error
    public NdArray reshape(int... newShape) {
        if (computeSize(newShape) != this.size)
            throw new IllegalArgumentException(
                "Cannot reshape: size mismatch"
            );
        return NdArrayFactory.fromRaw(this.data, newShape);
    }

    // display
    @Override
    public String toString() {
        return NdArrayPrinter.toString(this);
    }

    // internal accessors for sub-classes and printer
    public float[] getData()  { return data; }
    public int[] getShape() { return shape; }

    // utilitaries
    private static int computeSize(int[] shape) {
        int s = 1;
        for (int d : shape) s *= d;
        return s;
    }
}
