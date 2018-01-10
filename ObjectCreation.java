import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ObjectCreation {
    public static void main(String... args) {
        // By using 'new' keyword
        SomeObject so1 = new SomeObject();
        so1.setName("First");
        System.out.println(so1);
        // By using Class class's newInstance() method
        SomeObject so2 = null;
		try {
			so2 = (SomeObject) Class.forName("SomeObject")
			                       .newInstance();
		} catch (InstantiationException | IllegalAccessException |
		ClassNotFoundException e) {
			e.printStackTrace();
		}
        so2.setName("Second");
        System.out.println(so2);
        // Or we can simply do this:
        SomeObject so3 = null;
		try {
			so3 = SomeObject.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		so3.setName("Third");
        System.out.println(so3);
        // By using Constructor class's newInstance() method
        Constructor<SomeObject> constructor = null;
        SomeObject so4 = null;
        try {
        	constructor = SomeObject.class.getConstructor();
        	so4 = constructor.newInstance();
        } catch (InstantiationException | IllegalArgumentException |
        		InvocationTargetException | NoSuchMethodException | 
        		SecurityException | IllegalAccessException e) {
        	e.printStackTrace();
        }
        so4.setName("Fourth");
        System.out.println(so4);
        // By using clone() method
        SomeObject so5 = (SomeObject) so4.clone();
        so5.setName("Fifth");
        System.out.println(so5);
        // By using Deserialization
        // Serialization
        ObjectOutputStream out = null;
        try {
			out = new ObjectOutputStream(new FileOutputStream("data.obj"));
	        out.writeObject(so5);
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //Deserialization
        SomeObject so6 = null;
        ObjectInputStream in = null;
        try {
			in = new ObjectInputStream(new FileInputStream("data.obj"));
			so6 = (SomeObject) in.readObject();
	        in.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        so6.setName("Sixth");
        System.out.println(so6);
        ClassLoader cl = SomeObject.class.getClassLoader(); //get ClassLoader
        SomeObject so7 = null;
        try {
			so7 = (SomeObject)cl.loadClass("SomeObject").newInstance();
		} catch (InstantiationException | IllegalAccessException |
				ClassNotFoundException e) {
			e.printStackTrace();
		}
        so7.setName("Seventh");
        System.out.println(so7);
    }
}
class SomeObject implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    public SomeObject() {
        System.out.println("SomeObject Constructor");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {  
        return 31 * ((name == null) ? 0 : name.hashCode());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SomeObject other = (SomeObject) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "SomeObject [name = " + name + ", hashcode = " + hashCode() + "]";
    }
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}