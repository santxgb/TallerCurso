import java.util.Scanner;
public class ElectiveCourseCrud {
    private Management<ElectiveCourse> management = new Management<>();
    private Scanner scanner;
    public ElectiveCourseCrud(Scanner scanner) {
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
        System.out.println("Creditos: ");
        int credits = Integer.parseInt(scanner.nextLine());
        System.out.println("Modalidad: ");
        String modality = scanner.nextLine();
        System.out.println("Descripción: ");
        String description = scanner.nextLine();
        System.out.println("Área: ");
        String area = scanner.nextLine();
        System.out.println("Créditos mínimos requeridos: ");
        int minCredits = Integer.parseInt(scanner.nextLine());
        System.out.println("Fecha de aprobación: ");
        String fechaAprov = scanner.nextLine();
        System.out.println("¿Está abierto? (true/false): ");
        boolean abierto = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Departamento: ");
        String department = scanner.nextLine();

        if (management.insertObject(new ElectiveCourse(id, name, code, credits, modality, description, area, minCredits, fechaAprov, abierto, department)))
            System.out.println("Curso electivo creado exitosamente");
        else System.out.println("Ya existe un curso electivo con ese ID.");
    }
    private void buscar(){
        System.out.println("\n Ingrese el id que busca: ");
        ElectiveCourse e = management.findObjectById(scanner.nextLine());
        //Se utilizan los operadores ternarios (Se parecen al funcionamieto de los if y else)
        System.out.println(e != null ? e : "No encontrado");
    }
    private void actualizar(){
        System.out.println("\n Ingrese el id que necesita acualizar: ");
        Student actual = management.findObjectById(scanner.nextLine());
        if (actual == null){
            System.out.println("Este id no está asignado a ningún estudiante");
            return;
        }
        System.out.println("Este es el estudiante actual: " + actual);
        System.out.println("En dado caso de que no desee cambiar el dato del estudiante presiona la tecla ENTER");
        System.out.println("Nombre a cambiar [ " + actual.getName() + " ]: ");
        String nombre = scanner.nextLine();
        if (nombre.isBlank()) nombre = actual.getName();

        System.out.println("Código a cambiar [" + actual.getCode() + " ]: ");
        String code = scanner.nextLine();
        if (code.isBlank()) code = actual.getCode();

        System.out.println("Semestre a cambiar [" + actual.getSemester() + " ]: ");
        String semester = scanner.nextLine();
        int sem = semester.isBlank() ? actual.getSemester() : Integer.parseInt(semester);

        System.out.println("Promedio a cambiar [" + actual.getAverage() + " ]: ");
        String avg = scanner.nextLine();
        double average = avg.isBlank() ? actual.getAverage() : Double.parseDouble(avg);

        if(management.updateObject(new Student(actual.getId(), nombre, code, sem, average)))
            System.out.println("Actualizado exitosamente");
        else 
            System.out.println("No se pudo actualizar el registro del estudiante");
    }
    private void eliminar(){
        System.out.println("\n Id a eliminar: ");
        System.out.println(management.deleteObjetct(scanner.nextLine()) ? "Estudiante Eliminado exitosamente" : "No se encontró el estudiante a eliminar");
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
