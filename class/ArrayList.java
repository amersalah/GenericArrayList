package revision.genericLab1;

public class MyArrayList<E>  {

private Object[] array;
public static final int DEFAULT_SIZE = 20;
private int size = 0;

public MyArrayList(){
    this(DEFAULT_SIZE);
}

public MyArrayList(int size){
    array = new Object[size];
}

public void add(E element){
    ensureCapacity();
    array[size++] = element;
}

public E remove(int index){
    if(index>=size || index < 0 ){throw new RuntimeException("Invalid index");}
    E element = (E) array[index];
    --size;
    System.arraycopy(array, index + 1, array, index, size - index);
    array[size] = null;
    return element;
}

public E get(int index){
    if(index > size){throw new RuntimeException("Invalid index");}
    E element = (E) array[index];
    return element;
}

public int size(){
    return this.size;
}

private void ensureCapacity(){
    if(size < array.length){ return;}
    resize();
}

private void resize(){
    Object[] temp = new Object[array.length*2];
    copy(array,temp);
    array = temp;
}

private void copy(Object[] src, Object[] dest){
    if(dest.length< src.length){throw new RuntimeException(src+ " cannot be copied into "+dest);}
    for(int i=0;i<src.length; i++){
        dest[i] = src[i];
    }   
}

}