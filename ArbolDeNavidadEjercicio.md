
# Ejercicio: Árbol de Navidad en Consola con Java

## Descripción
El objetivo de este ejercicio es crear un programa de consola en Java que dibuje un árbol de Navidad. El usuario debe ingresar la altura del árbol, y el programa generará el árbol correspondiente.

## Código de Ejemplo
Aquí se muestra un ejemplo de cómo implementar este programa en Java:

```java
public class XMassTree {
  public static void main(String[] args) {
      
    Scanner scanner = new Scanner(System.in);
    int height = getHeight(scanner);
    
    for (int i = 0; i < height; i++) {
      printingTreeNodes(height - i, " ");
      printingTreeNodes((2 * i + 1), "*");
      System.out.println();
    }
  }
  
  private static int getHeight(Scanner scanner) {
    System.out.print("Insert Tree Height: ");
    int height = scanner.nextInt();
    System.out.print("\n");
    return height;
  }
  
  private static void printingTreeNodes(int i, String s) {
    for (int k = 0; k < i; k++) {
      System.out.print(s);
    }
  }
}
```

## Explicación
- Se utiliza `Scanner` para leer la entrada del usuario.
- Se usa un bucle `for` externo para iterar sobre cada nivel del árbol.
- Dentro de este bucle, hay dos bucles `for` internos:
  - El primero imprime espacios para centrar los asteriscos en cada nivel.
  - El segundo imprime los asteriscos que forman el árbol.
- La cantidad de asteriscos en cada nivel sigue un patrón, donde cada nivel tiene dos asteriscos más que el anterior (excepto el primero que comienza con uno). Esto se logra con la fórmula `2 * i + 1`.
- Después de completar un nivel, se imprime un salto de línea para comenzar el siguiente.
