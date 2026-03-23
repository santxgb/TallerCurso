
import java.util.Scanner;
public class CourseCrud {
    private Management<Course> management = new Management<>();
    private Scanner scanner;
    public CourseCrud(Scanner scanner) {
        this.scanner = scanner;
    }
    public void menu(){
        String menu = """
                ----CRUD Curso----
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
        System.out.println("\n---Crear Curso ----");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Nombre: ");
        String name = scanner.nextLine(); 
        System.out.println("Código: ");
        String code = scanner.nextLine();
        System.out.println("Créditos: ");
        int credits = Integer.parseInt(scanner.nextLine());
        System.out.println("Modalidad: ");
        String modality = scanner.nextLine();
        System.out.println("Descripción: ");
        String description = scanner.nextLine();


        if (management.insertObject(new Course(id, name, code, credits, modality, description)))
            System.out.println("Curso creado exitosamente");
        else 
            System.out.println("Ya existe un Curso con ese ID.");
    }
    private void buscar(){
        System.out.println("\n Ingrese el id que busca: ");
        Course c = management.findObjectById(scanner.nextLine());
        //Se utilizan los operadores ternarios (Se parecen al funcionamieto de los if y else)
        System.out.println(c != null ? c : "No encontrado");
    }
    private void actualizar(){
    System.out.println("\n Ingrese el id que necesita actualizar: ");
    Course actual = management.findObjectById(scanner.nextLine());
    if (actual == null){
        System.out.println("Este id no está asignado a ningún Curso");
        return;
    }

    System.out.println("Este es el Curso actual: " + actual);
    System.out.println("Presiona ENTER si no deseas cambiar el dato.");

    System.out.println("Nombre a cambiar [ " + actual.getName() + " ]: ");
    String name = scanner.nextLine();
    if (!name.isBlank()) actual.setName(name);  // ← solo cambia si el usuario escribió algo

    System.out.println("Código a cambiar [ " + actual.getCode() + " ]: ");
    String code = scanner.nextLine();
    if (!code.isBlank()) actual.setCode(code);

    System.out.println("Créditos a cambiar [ " + actual.getCredits() + " ]: ");
    String credits = scanner.nextLine();
    if (!credits.isBlank()) actual.setCredits(Integer.parseInt(credits));

    System.out.println("Modalidad a cambiar [ " + actual.getModality() + " ]: ");
    String modality = scanner.nextLine();
    if (!modality.isBlank()) actual.setModality(modality);

    System.out.println("Descripción a cambiar [ " + actual.getDescription() + " ]: ");
    String description = scanner.nextLine();
    if (!description.isBlank()) actual.setDescription(description);
    if (management.updateObject(actual))
        System.out.println("Actualizado exitosamente");
    else
        System.out.println("No se pudo actualizar el registro del Curso");
}
    private void eliminar(){
        System.out.println("\n Id a eliminar: ");
        System.out.println(management.deleteObjetct(scanner.nextLine()) ? "Curso Eliminado exitosamente" : "No se encontró el Curso a eliminar");
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

