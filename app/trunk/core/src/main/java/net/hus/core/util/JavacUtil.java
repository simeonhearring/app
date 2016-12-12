package net.hus.core.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public final class JavacUtil
{
  private static final String COMPILE_PATH =
      System.getProperty("user.home") + "/jvm/apache-tomcat-7.0.23/classes/";

  public static boolean compile(String inFileName)
  {
    return compile(new JavaFileSource(inFileName));
  }

  public static boolean compile(String inFileName, String inJavaCode)
  {
    return compile(new JavaCodeSource(inFileName, inJavaCode));
  }

  public static boolean compile(SimpleJavaFileObject inJavaFile)
  {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

    Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(inJavaFile);

    final Iterable<String> options = Arrays.asList(new String[]
        {
            "-d",
            COMPILE_PATH
        });

    CompilationTask task =
        compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits);

    Boolean ret = task.call();

    if (!ret)
    {
      print(diagnostics);
    }

    return ret;
  }

  public static void run(String inClassName)
  {
    try
    {
      ((Runnable) loadClass(inClassName).newInstance()).run();
    }
    catch (Exception e)
    {
      throw new RuntimeException("JAVAC EXCEPTION", e);
    }
  }

  private static Class<?> loadClass(String inClassName) throws IOException
  {
    URLClassLoader loader = null;
    Class<?> ret = null;

    try
    {
      loader = new URLClassLoader(new URL[]
          {
              new File(COMPILE_PATH).toURI().toURL()
          });
      ret = loader.loadClass(inClassName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (loader != null)
      {
        loader.close();
      }
    }

    return ret;
  }

  private static void print(DiagnosticCollector<JavaFileObject> inDiagnostics)
  {
    for (Diagnostic<?> diagnostic : inDiagnostics.getDiagnostics())
    {
      System.out.println("1." + diagnostic.getCode());
      System.out.println("2." + diagnostic.getKind());
      System.out.println("3." + diagnostic.getPosition());
      System.out.println("4." + diagnostic.getStartPosition());
      System.out.println("5." + diagnostic.getEndPosition());
      System.out.println("6." + diagnostic.getSource());
      System.out.println("7." + diagnostic.getMessage(null));
    }
  }
}

class JavaFileSource extends SimpleJavaFileObject
{
  protected JavaFileSource(String inPath)
  {
    super(toUri(inPath), Kind.SOURCE);
  }

  private static URI toUri(String inPath)
  {
    return URI.create(inPath);
  }

  @Override
  public CharSequence getCharContent(boolean inIgnoreEncodingErrors)
  {
    String ret = null;
    try
    {
      ret = new String(Files.readAllBytes(Paths.get(toUri().getPath())));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return ret;
  }
}

class JavaCodeSource extends SimpleJavaFileObject
{
  private final String mCode;

  public JavaCodeSource(String inName, String inCode)
  {
    super(toUri(inName), Kind.SOURCE);
    this.mCode = inCode;
  }

  private static URI toUri(String inName)
  {
    String path = "string:///" + inName.replace('.', '/') + Kind.SOURCE.extension;
    return URI.create(path);
  }

  @Override
  public CharSequence getCharContent(boolean inIgnoreEncodingErrors)
  {
    return mCode;
  }
}
