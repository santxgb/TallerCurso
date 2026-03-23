
import java.util.Scanner;
public class ContentCrud {
    private Management<Content> management = new Management<>();
    private Scanner scanner;
    public ContentCrud(Scanner scanner) {
        this.scanner = scanner;
    }
    public void menu(){
        String menu = """
                ----CRUD Contenido----
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
        System.out.println("\n---Crear Contenido de Contenido ----");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Titulo: ");
        String title = scanner.nextLine(); 
        System.out.println("Descripción: ");
        String description = scanner.nextLine();
        System.out.println("Duración en horas: ");
        int durationHours = Integer.parseInt(scanner.nextLine());
        System.out.println("""
                =======================
                || Tipo de contenido ||
                =======================
                ||   [1] Teórico     ||
                ||   [2] Práctico    ||
                ||   [3] Laboratorio ||
                ||   [4] Taller      ||
                ||   [5] Evaluation  ||
                =======================
                """);
        int typeOp = Integer.parseInt(scanner.nextLine());
        ContentType type = switch (typeOp){
            case 1 -> ContentType.THEORY;
            case 2 -> ContentType.PRACTICE;
            case 3 -> ContentType.LAB;
            case 4 -> ContentType.WORKSHOP;
            case 5 -> ContentType.EVALUATION;
            default -> {
                System.out.println("Tipo inválido, Se asignará THEORY por defecto");
                yield ContentType.THEORY;
                //Utilicé yield, me tocó buscar por chatgpt que podía servir ahí porque me arrojaba error
            }
        };


        if (management.insertObject(new Content(id, title, description, type, durationHours)))
            System.out.println("Contenido creado exitosamente");
        else 
            System.out.println("Ya existe un Contenido con ese ID.");
    }
    private void buscar(){
        System.out.println("\n Ingrese el id que busca: ");
        Content c = management.findObjectById(scanner.nextLine());
        //Se utilizan los operadores ternarios (Se parecen al funcionamieto de los if y else)
        System.out.println(c != null ? c : "No encontrado");
    }
    private void actualizar(){
        System.out.println("\n Ingrese el id que necesita acualizar: ");
        Content actual = management.findObjectById(scanner.nextLine());
        if (actual == null){
            System.out.println("Este id no está asignado a ningún Contenido");
            return;
        }
        System.out.println("Este es el Contenido actual: " + actual);
        System.out.println("En dado caso de que no desee cambiar el dato del Contenido presiona la tecla ENTER");
        System.out.println("Título a cambiar [ " + actual.getTitle() + " ]: ");
        String title = scanner.nextLine();
        if (title.isBlank()) title = actual.getTitle();

        System.out.println("Descripción a cambiar [ " + actual.getDescription() + " ]: ");
        String description = scanner.nextLine();
        if (description.isBlank()) description = actual.getDescription();

        System.out.println("Creditos a cambiar [ " + actual.getDurationHours() + " ]: ");
        String durHours = scanner.nextLine();
        int durationHours = durHours.isBlank() ? actual.getDurationHours() : Integer.parseInt(durHours);

        System.out.println("Modalidad a cambiar [ " + actual.getType() + " ]: ");
        System.out.println("""
                    ========================
                    ||  RECUERDE EL ORDEN ||
                    ||                    ||
                    ||====================||
                    ||  [1]THEORY         ||
                    ||  [2]PRACTICE       ||
                    ||  [3]LAB            ||
                    ||  [4]WORKSHOP       ||
                    ||  [5]EVALUATION     ||
                    ||  [1]THEORY         ||
                    ========================
                    """);
        String tipoStr = scanner.nextLine();
        ContentType type = tipoStr.isBlank() ? actual.getType() : switch (tipoStr){
                case "1" -> ContentType.THEORY;
            case "2" -> ContentType.PRACTICE;
            case "3" -> ContentType.LAB;
            case "4" -> ContentType.WORKSHOP;
            case "5" -> ContentType.EVALUATION;
            default -> {
                System.out.println("Opción inválida, se mantiene el tipo actual.");
                yield actual.getType();
            }
        };

        if(management.updateObject(new Content(actual.getId(), title, description, type, durationHours)))
            System.out.println("Actualizado exitosamente");
        else 
            System.out.println("No se pudo actualizar el registro del Contenido");
    }
    private void eliminar(){
        System.out.println("\n Id a eliminar: ");
        System.out.println(management.deleteObjetct(scanner.nextLine()) ? "Contenido Eliminado exitosamente" : "No se encontró el Contenido a eliminar");
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

