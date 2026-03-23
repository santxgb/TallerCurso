import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentCrud studentCrud = new StudentCrud(scanner);
        TeacherCrud teacherCrud = new TeacherCrud(scanner);
        CourseCrud courseCrud = new CourseCrud(scanner);
        String menuPrincipal = """
            ==================================
            ||      SISTEMA DE CURSOS       ||
            ||                              ||
            ==================================
            ||  [1] Gestionar Estudiantes   ||
            ||  [2] Gestionar Profesores    ||
            ||  [3] Gestionar Cursos        ||
            ||  [4] Gestionar Electivas C.  ||
            ||  [5] Gestionar Contenidos    ||
            ||  [6] Salir                   ||
            ==================================
                """;
        boolean menuWorking = true;
        do{
            System.out.println(menuPrincipal);
            System.out.println("Seleccione lo que desea hacer: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1-> studentCrud.menu();
                case 2 -> teacherCrud.menu();
                case 3 -> courseCrud.menu();
                default -> System.out.println("Opción no válida.");
            }

        }while (menuWorking);
    }
}
