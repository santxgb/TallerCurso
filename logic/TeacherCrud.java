import java.util.Scanner;
public class TeacherCrud {
    private Management<Teacher> management = new Management<>();
    private Scanner scanner;
    public TeacherCrud(Scanner scanner) {
        this.scanner = scanner;
    }
    public void menu(){
        String menu = """
                ----CRUD Profesores----
                [1] Crear 
                [2] Buscar por ID
                [3] Actualizar
                [4] Eliminar
                [5] Listar todos
                [6] Volver
                """;
        boolean activo = true;
        do {
            System.out.println(menu);
            System.out.println("Elija la opción: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> crear();
                case 2 -> buscar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 5 -> listar();
                case 6 -> activo = false;
                default -> System.out.println("Opción invalida");
            }
        } while (activo);
    }
    private void crear(){
        System.out.println("\n---Crear Profesor ----");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Nombre: ");
        String name = scanner.nextLine(); 
        System.out.println("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Especialidad: ");
        String speciality = scanner.nextLine();

        if (management.insertObject(new Teacher(id, name, email, lastName,  speciality)))
            System.out.println("Profesor creado exitosamente");
        else System.out.println("Ya existe un Profesor con ese ID.");
    }
    private void buscar(){
        System.out.println("\n Ingrese el id que busca: ");
        Teacher t = management.findObjectById(scanner.nextLine());
        //Se utilizan los operadores ternarios (Se parecen al funcionamieto de los if y else)
        System.out.println(t != null ? t : "No encontrado");
    }
    private void actualizar(){
        System.out.println("\n Ingrese el id que necesita acualizar: ");
        Teacher actual = management.findObjectById(scanner.nextLine());
        if (actual == null){
            System.out.println("Este id no está asignado a ningún Profesor");
            return;
        }
        System.out.println("Este es el Profesor actual: " + actual);
        System.out.println("En dado caso de que no desee cambiar el dato del Profesor presiona la tecla ENTER");
        System.out.println("Nombre a cambiar [ " + actual.getName() + " ]: ");
        String name = scanner.nextLine();
        if (name.isBlank()) name = actual.getName();

        System.out.println("apellido a cambiar [ " + actual.getLastName() + " ]: ");
        String lastName = scanner.nextLine();
        if (lastName.isBlank()) lastName = actual.getLastName();

        System.out.println("Email a cambiar [ " + actual.getEmail() + " ]: ");
        String email = scanner.nextLine();
        if (email.isBlank()) email = actual.getEmail();

        System.out.println("Especialidad a cambiar [ " + actual.getSpeciality() + " ]: ");
        String speciality = scanner.nextLine();
        if (speciality.isBlank()) speciality = actual.getSpeciality();

        if(management.updateObject(new Teacher(actual.getId(), name, email, lastName, speciality)))
            System.out.println("Actualizado exitosamente");
        else 
            System.out.println("No se pudo actualizar el registro del Profesor");
    }
    private void eliminar(){
        System.out.println("\n Id a eliminar: ");
        System.out.println(management.deleteObjetct(scanner.nextLine()) ? "Profesor Eliminado exitosamente" : "No se encontró el Profesor a eliminar");
    }
    private void listar() {
        if (management.getListObject().isEmpty()) { 
            System.out.println("Sin registros."); 
            return; 
        }
        management.getListObject().forEach(System.out::println);
        System.out.println("Total: " + management.getListObject().size());
    }

}

