import java.util.Scanner;

public class ElectiveCourseCrud {
    private Management<ElectiveCourse> management = new Management<>();
    private Scanner scanner;
    public ElectiveCourseCrud(Scanner scanner) {
        this.scanner = scanner;
    }
    public void menu(){
        String menu = """
                ----CRUD Electiva de cursoS----
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
        System.out.println("\n---Crear Electiva de curso ----");
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
    System.out.println("\n Ingrese el id que necesita actualizar: ");
    ElectiveCourse actual = management.findObjectById(scanner.nextLine());
    if (actual == null){
        System.out.println("Este id no está asignado a ningún Curso Electivo");
        return;
    }

    System.out.println("Este es el Curso Electivo actual: " + actual);
    System.out.println("Presiona ENTER si no deseas cambiar el dato.");

    System.out.println("Nombre a cambiar [ " + actual.getName() + " ]: ");
    String nombre = scanner.nextLine();
    if (!nombre.isBlank()) actual.setName(nombre);

    System.out.println("Código a cambiar [ " + actual.getCode() + " ]: ");
    String code = scanner.nextLine();
    if (!code.isBlank()) actual.setCode(code);

    System.out.println("Créditos a cambiar [ " + actual.getCredits() + " ]: ");
    String cred = scanner.nextLine();
    if (!cred.isBlank()) actual.setCredits(Integer.parseInt(cred));

    System.out.println("Modalidad a cambiar [ " + actual.getModality() + " ]: ");
    String modality = scanner.nextLine();
    if (!modality.isBlank()) actual.setModality(modality);

    System.out.println("Descripción a cambiar [ " + actual.getDescription() + " ]: ");
    String description = scanner.nextLine();
    if (!description.isBlank()) actual.setDescription(description);

    System.out.println("Área a cambiar [ " + actual.getArea() + " ]: ");
    String area = scanner.nextLine();
    if (!area.isBlank()) actual.setArea(area);

    System.out.println("Créditos mínimos a cambiar [ " + actual.getMinCreditsRequired() + " ]: ");
    String minCred = scanner.nextLine();
    if (!minCred.isBlank()) actual.setMinCreditsRequired(Integer.parseInt(minCred));

    System.out.println("Fecha de aprobación a cambiar [ " + actual.getApprovalDate() + " ]: ");
    String fechaAprov = scanner.nextLine();
    if (!fechaAprov.isBlank()) actual.setApprovalDate(fechaAprov);

    System.out.println("¿Está abierto? (true/false) [ " + actual.isOpen() + " ]: ");
    String abierto = scanner.nextLine();
    if (!abierto.isBlank()) actual.setOpen(Boolean.parseBoolean(abierto));

    System.out.println("Departamento a cambiar [ " + actual.getDepartment() + " ]: ");
    String department = scanner.nextLine();
    if (!department.isBlank()) actual.setDepartment(department);

    if (management.updateObject(actual))
        System.out.println("Actualizado exitosamente");
    else
        System.out.println("No se pudo actualizar el Curso Electivo");
}
    
    private void eliminar(){
        System.out.println("\n Id a eliminar: ");
        System.out.println(management.deleteObject(scanner.nextLine()) ? "Electiva de curso Eliminado exitosamente" : "No se encontró el Electiva de curso a eliminar");
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
