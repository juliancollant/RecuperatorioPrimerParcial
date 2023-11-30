import java.util.*;
import java.io.*;

public class SistemaEscolar {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // Agregar profesores
        sistema.profesores.add(new Profesor("facundo", "uferer", "41222333", "01/01/1980", "Java"));
        sistema.profesores.add(new Profesor("peter", "Gaga", "822221", "15/06/1975", "Python"));
        sistema.profesores.add(new Profesor("tito", "López", "166666", "22/11/1990", "BD"));

        // Agregar estudiantes
        sistema.estudiantes.add(new Estudiante("juli", "collante", "11111111", "05/03/2000", "001"));
        sistema.estudiantes.add(new Estudiante("eli", "cuesta", "22222222", "10/09/2001", "002"));
        sistema.estudiantes.add(new Estudiante("javier", "milei", "33333333", "20/12/1999", "003"));


        // Asignar profesor a cargo por su DNI
        sistema.materias.add(new Materia("Java", "41222333"));
        sistema.materias.add(new Materia("Python", "82222222"));
        sistema.materias.add(new Materia("BD", "16666666"));

        sistema.menuPrincipal();
    }
    public static class Sistema {
        private List<Profesor> profesores = new ArrayList<>();
        private List<Estudiante> estudiantes = new ArrayList<>();
        private List<Materia> materias = new ArrayList<>();

        public void menuPrincipal() {
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;
            while (continuar) {
                System.out.println("Menú:");
                System.out.println("1. Listar Profesores.");
                System.out.println("2. Listar Estudiantes.");
                System.out.println("3. Listar Materias.");
                System.out.println("4. Registrar un nuevo profesor.");
                System.out.println("5. Registrar un nuevo estudiante.");
                System.out.println("6. Asignar profesor a materia.");
                System.out.println("7. Inscribir estudiante a materia.");
                System.out.println("8. Guardar Información en Archivo.");
                System.out.println("9. Cargar Información desde Archivo.");
                System.out.println("10. SALIR ");
                System.out.println("Seleccione una opción:");

                int opcionMenu = scanner.nextInt();
                scanner.nextLine();
                switch (opcionMenu) {
                    case 1:
                        listarProfesores();
                        break;
                    case 2:
                        listarEstudiantes();
                        break;
                    case 3:
                        listarMaterias();
                        break;
                    case 4:
                        agregarProfesor();
                        break;
                    case 5:
                        registroDeEstudiante();
                        break;
                    case 6:
                        asignarProfesorAMateria();
                        break;
                    case 7:
                        inscribirEstudianteAMateria();
                        break;
                    case 8:
                        guardarEnArchivo();
                    break;
                    case 9:
                        cargarDesdeArchivo();;
                        break;
                    case 10:
                        continuar = false;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            }

        }

        private void agregarProfesor() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del nuevo profesor:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del nuevo profesor:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el DNI del nuevo profesor:");
            String dni = scanner.nextLine();

            System.out.println("Ingrese la fecha de nacimiento del nuevo profesor (dd/MM/yyyy):");
            String fechaNacimiento = scanner.nextLine();

            System.out.println("Ingrese la especialidad del nuevo profesor:");
            String especialidad = scanner.nextLine();

            profesores.add(new Profesor(nombre, apellido, dni, fechaNacimiento, especialidad));
            System.out.println("Profesor registrado correctamente.");

        }

        private void registroDeEstudiante() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del nuevo estudiante:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del nuevo estudiante:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el DNI del nuevo estudiante:");
            String dni = scanner.nextLine();

            System.out.println("Ingrese la fecha de nacimiento del nuevo estudiante (dd/MM/yyyy):");
            String fechaNacimiento = scanner.nextLine();

            System.out.println("Ingrese el ID del nuevo estudiante:");
            String idEstudiante = scanner.nextLine();

            estudiantes.add(new Estudiante(nombre, apellido, dni, fechaNacimiento, idEstudiante));
            System.out.println("Estudiante registrado correctamente.");

        }

        private void listarProfesores() {
            System.out.println("Lista de Profesores:");
            for (Profesor profesor : profesores) {
                System.out.println("Nombre : " + profesor.getNombre());
                System.out.println("Apellido : " + profesor.getApellido());
                System.out.println("DNI: " + profesor.getDni());
                System.out.println("Fecha de Nacimiento: " + profesor.getFechaNac());
                System.out.println("Especialidad: " + profesor.getEspecialidad());
                System.out.println();
            }

        }

        private void listarEstudiantes() {
            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes registrados.");
            } else {
                System.out.println("Lista de Estudiantes:");
                for (Estudiante estudiante : estudiantes) {
                    System.out.println("Nombre: " + estudiante.getNombre());
                    System.out.println("Apellido: " + estudiante.getApellido());
                    System.out.println("DNI: " + estudiante.getDni());
                    System.out.println("Fecha de Nacimiento: " + estudiante.getFechaNac());
                    System.out.println("ID del Estudiante: " + estudiante.getIdEstudiante());
                    System.out.println("-----------------------------");
                }
            }
            // Resto del código
        }

        private void listarMaterias() {
            if (materias.isEmpty()) {
                System.out.println("No hay materias registradas.");
            } else {
                System.out.println("Lista de Materias:");
                for (Materia materia : materias) {
                    System.out.println("Nombre: " + materia.getNombre());
                    System.out.println("Profesor a cargo (DNI): " + materia.getProfesorACargo());
                    System.out.println("-----------------------------");
                }
            }
            // Resto del código
        }

        private void asignarProfesorAMateria() {
            Scanner scanner = new Scanner(System.in);

            if (materias.isEmpty() || profesores.isEmpty()) {
                System.out.println("No hay materias o profesores registrados para asignar.");
                return;
            }

            System.out.println("Lista de Materias:");
            for (int i = 0; i < materias.size(); i++) {
                System.out.println((i + 1) + ". " + materias.get(i).getNombre());
            }

            System.out.println("Seleccione el número de la materia a la que desea asignar un profesor:");
            int opcionMateria = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcionMateria < 1 || opcionMateria > materias.size()) {
                System.out.println("Opción de materia no válida.");
                return;
            }

            System.out.println("Lista de Profesores:");
            for (int i = 0; i < profesores.size(); i++) {
                System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
            }

            System.out.println("Seleccione el número del profesor a asignar:");
            int opcionProfesor = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcionProfesor < 1 || opcionProfesor > profesores.size()) {
                System.out.println("Opción de profesor no válida.");
                return;
            }

            // Asignar el profesor seleccionado a la materia seleccionada
            String dniProfesor = profesores.get(opcionProfesor - 1).getDni();
            materias.get(opcionMateria - 1).setProfesorACargo(dniProfesor);

            System.out.println("Profesor asignado a la materia correctamente.");
            // Resto del código
        }

        private void inscribirEstudianteAMateria() {
            Scanner scanner = new Scanner(System.in);

            if (materias.isEmpty() || estudiantes.isEmpty()) {
                System.out.println("No hay materias o estudiantes registrados para inscribir.");
                return;
            }

            System.out.println("Lista de Materias:");
            for (int i = 0; i < materias.size(); i++) {
                System.out.println((i + 1) + ". " + materias.get(i).getNombre());
            }

            System.out.println("Seleccione el número de la materia a la que desea inscribir al estudiante:");
            int opcionMateria = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcionMateria < 1 || opcionMateria > materias.size()) {
                System.out.println("Opción de materia no válida.");
                return;
            }

            System.out.println("Lista de Estudiantes:");
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
            }

            System.out.println("Seleccione el número del estudiante a inscribir:");
            int opcionEstudiante = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcionEstudiante < 1 || opcionEstudiante > estudiantes.size()) {
                System.out.println("Opción de estudiante no válida.");
                return;
            }

            // Inscribir al estudiante seleccionado en la materia seleccionada
            String idEstudiante = estudiantes.get(opcionEstudiante - 1).getIdEstudiante();
            materias.get(opcionMateria - 1).agregarEstudiante(idEstudiante);

            System.out.println("Estudiante inscrito en la materia correctamente.");
            // Resto del código
        }

        private void guardarEnArchivo() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("informacion.dat");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(profesores);
                objectOutputStream.writeObject(estudiantes);
                objectOutputStream.writeObject(materias);

                objectOutputStream.close();
                fileOutputStream.close();
                System.out.println("Información guardada correctamente en 'informacion.dat'.");
            } catch (IOException e) {
                System.out.println("Error al guardar la información: " + e.getMessage());
            }

            // Resto del código
        }

        private void cargarDesdeArchivo() {
            try {
                FileInputStream fileInputStream = new FileInputStream("informacion.dat");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                profesores = (List<Profesor>) objectInputStream.readObject();
                estudiantes = (List<Estudiante>) objectInputStream.readObject();
                materias = (List<Materia>) objectInputStream.readObject();

                objectInputStream.close();
                fileInputStream.close();
                System.out.println("Información cargada correctamente desde 'informacion.dat'.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar la información: " + e.getMessage());
            }

        }
    }
}
class Persona implements Serializable {
    private String nombre, apellido, dni, fechaNac;

    public Persona(String nombre, String apellido, String dni, String fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
}

class Estudiante extends Persona implements Serializable{
    private String idEstudiante;

    public Estudiante(String nombre, String apellido, String dni, String fechaNac, String idEstudiante) {
        super(nombre, apellido, dni, fechaNac);
        this.idEstudiante = idEstudiante;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
}

class Profesor extends Persona implements Serializable{
    private String especialidad;

    public Profesor(String nombre, String apellido, String dni, String fechaNac, String especialidad) {
        super(nombre, apellido, dni, fechaNac);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
}

class Materia implements Serializable{
    private String nombre;
    private String profesorACargo;
    private List<String> estudiantesInscritos; // Lista de estudiantes inscritos en la materia

    public Materia(String nombre, String profesorACargo) {
        this.nombre = nombre;
        this.profesorACargo = profesorACargo;
        this.estudiantesInscritos = new ArrayList<>(); // Inicializar la lista
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesorACargo() {
        return profesorACargo;
    }

    public void setProfesorACargo(String profesorACargo) {
        this.profesorACargo = profesorACargo;
    }

    public void setEstudiantesInscritos(List<String> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }



    public List<String> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void agregarEstudiante(String idEstudiante) {
        estudiantesInscritos.add(idEstudiante);
    }
}
