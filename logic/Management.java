import java.util.ArrayList;
import java.util.List;
 
public class Management<T extends BaseClass> {
 
    private List<T> listObject;
 
    public Management() {
        this.listObject = new ArrayList<>();
    }
    
    public boolean insertObject(T object){
        // Si el id no existe se crea (insert) como objetc
        if (this.findObjectById(object.getId()) == null){
            this.listObject.add(object);
            //Retorna verdadero si ya se insertó y falso si ya había un id (un duplicado)
            return true;
        }
        return false;
    }
    //Metodo para buscar un id del objeto y retornarlo en dado caso de que exista. Si no existe se retorna null
    public T findObjectById(String id){
        for (T obj : listObject){
            if (obj.getId().equals(id)){
                return obj;
            }
        }
        return null;
    }
    //Metodo para retornar la posición del objeto dentro de la lsita o -1 en dado caso de que el objeto no exista
    public int findIndexById(String id){
        for(int i = 0; i < listObject.size(); i++){
            if(listObject.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    /*
    -Reemplaza el objeto que tiene el mismo id que newObject.
    -Retorna true si se actualizó, false si el id no existía.
    */
    public boolean updateObject(T newObject){
        int index = this.findIndexById(newObject.getId());
        if(index == -1){
            return false;
        }
        this.listObject.set(index, newObject);
        return true;
    }
    //Elimina el objeto con el id que ingrese el usuario
    //Retrona true si se eliminó el objeto y false si el objeto no existía
    public boolean deleteObjetct(String id){
        int index = this.findIndexById(id);
        if (index == -1){
            return false;
        }
        this.listObject.remove(index);
        return true;
    }

    public List<T> getListObject() {
        return listObject;
    }
}
