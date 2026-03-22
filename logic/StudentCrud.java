import java.util.Scanner;
public class StudentCrud {
    private Management<Student> management = new Management<>();
    private Scanner scanner;
    public StudentCrud(Scanner scanner) {
        this.scanner = scanner;
    }
    public void menu(){
        String menu = """
                ----CRUD ESTUDIANTES----
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
        System.out.println("\n---Crear Estudiante ----");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Nombre: ");
        String name = scanner.nextLine(); 
        System.out.println("Código: ");
        String code = scanner.nextLine();
        System.out.println("Semestre: ");
        int semester = Integer.parseInt(scanner.nextLine());
        System.out.println("promedio: ");
        double average = Double.parseDouble(scanner.nextLine());

        if (management.insertObject(new Student(id, name, code, semester, average)))
            System.out.println("Estudiante creado exitosamente");
        else System.out.println("Ya existe un estudiante con ese ID.");
    }
    private void buscar(){
        System.out.println("\n Ingrese el id que busca: ");
        Student s = management.findObjectById(scanner.nextLine());
        //Se utilizan los operadores ternarios (Se parecen al funcionamieto de los if y else)
        System.out.println(s != null ? s : "No encontrado");
    }
    private void actualizar(){
        System.out.println("\n Ingrese el id que necesita acualizar: ");
        Student actual = management.findObjectById(scanner.nextLine());
        if (actual == null){
            System.out.println("Este id no está asignado a ningún estudiante");
            return;
        }
        System.out.println("Este es el Id actual: " + actual);

    }
}
