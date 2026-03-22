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
    }
}
