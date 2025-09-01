package lombok.delombok;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import lombok.core.LombokApp;
import lombok.permit.Permit;

/* loaded from: discord:lombok/delombok/DelombokApp.SCL.lombok */
public class DelombokApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) throws Exception {
        try {
            Class.forName("com.sun.tools.javac.main.JavaCompiler");
            runDirectly(args);
            return 0;
        } catch (ClassNotFoundException unused) {
            Class<?> delombokClass = loadDelombok(args);
            if (delombokClass == null) {
                return 1;
            }
            try {
                Permit.getMethod(loadDelombok(args), "main", String[].class).invoke(null, args.toArray(new String[0]));
                return 0;
            } catch (InvocationTargetException e1) {
                Throwable t = e1.getCause();
                if (t instanceof Error) {
                    throw ((Error) t);
                }
                if (t instanceof Exception) {
                    throw ((Exception) t);
                }
                throw e1;
            }
        }
    }

    public static Class<?> loadDelombok(List<String> args) throws Exception {
        File toolsJar = findToolsJar();
        if (toolsJar == null) {
            String examplePath = File.separator.equals("\\") ? "C:\\path\\to\\tools.jar" : "/path/to/tools.jar";
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                if (arg.contains(" ")) {
                    sb.append('\"').append(arg).append('\"');
                } else {
                    sb.append(arg);
                }
            }
            System.err.printf("Can't find tools.jar. Rerun delombok as: java -cp lombok.jar%1$s%2$s lombok.launch.Main delombok %3$s\n", File.pathSeparator, examplePath, sb.toString());
            return null;
        }
        JarFile toolsJarFile = new JarFile(toolsJar);
        ClassLoader loader = new AnonymousClass1(DelombokApp.class.getClassLoader(), toolsJarFile, toolsJar);
        return loader.loadClass("lombok.delombok.Delombok");
    }

    /* renamed from: lombok.delombok.DelombokApp$1, reason: invalid class name */
    /* loaded from: discord:lombok/delombok/DelombokApp$1.SCL.lombok */
    class AnonymousClass1 extends ClassLoader {
        private final /* synthetic */ JarFile val$toolsJarFile;
        private final /* synthetic */ File val$toolsJar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ClassLoader $anonymous0, JarFile jarFile, File file) {
            super($anonymous0);
            this.val$toolsJarFile = jarFile;
            this.val$toolsJar = file;
        }

        private Class<?> loadStreamAsClass(String name, boolean resolve, InputStream in) throws IOException, ClassNotFoundException {
            try {
                try {
                    byte[] b2 = new byte[65536];
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    while (true) {
                        int r = in.read(b2);
                        if (r == -1) {
                            break;
                        }
                        out.write(b2, 0, r);
                    }
                    in.close();
                    byte[] data = out.toByteArray();
                    Class<?> c = defineClass(name, data, 0, data.length);
                    if (resolve) {
                        resolveClass(c);
                    }
                    return c;
                } finally {
                    in.close();
                }
            } catch (Exception e2) {
                throw new ClassNotFoundException(name, e2);
            }
        }

        @Override // java.lang.ClassLoader
        protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            String binName = name.replace(".", AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
            String rawName = String.valueOf(binName) + ".class";
            String altName = String.valueOf(binName) + ".SCL.lombok";
            JarEntry entry = this.val$toolsJarFile.getJarEntry(rawName);
            if (entry == null) {
                if (name.startsWith("lombok.")) {
                    InputStream res = getParent().getResourceAsStream(rawName);
                    if (res == null) {
                        res = getParent().getResourceAsStream(altName);
                    }
                    return loadStreamAsClass(name, resolve, res);
                }
                return super.loadClass(name, resolve);
            }
            try {
                return loadStreamAsClass(name, resolve, this.val$toolsJarFile.getInputStream(entry));
            } catch (IOException e2) {
                throw new ClassNotFoundException(name, e2);
            }
        }

        @Override // java.lang.ClassLoader
        public URL getResource(String name) {
            JarEntry entry = this.val$toolsJarFile.getJarEntry(name);
            if (entry == null) {
                return super.getResource(name);
            }
            try {
                return new URL("jar:file:" + this.val$toolsJar.getAbsolutePath() + "!" + name);
            } catch (MalformedURLException unused) {
                return null;
            }
        }

        @Override // java.lang.ClassLoader
        public Enumeration<URL> getResources(String name) throws IOException {
            JarEntry entry = this.val$toolsJarFile.getJarEntry(name);
            Enumeration<URL> parent = super.getResources(name);
            return entry == null ? super.getResources(name) : new C04351(parent, this.val$toolsJar, name);
        }

        /* renamed from: lombok.delombok.DelombokApp$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: discord:lombok/delombok/DelombokApp$1$1.SCL.lombok */
        class C04351 implements Enumeration<URL> {
            private boolean first = false;
            private final /* synthetic */ Enumeration val$parent;
            private final /* synthetic */ File val$toolsJar;
            private final /* synthetic */ String val$name;

            @Override // java.util.Enumeration
            public /* bridge */ /* synthetic */ URL nextElement() {
                return nextElement();
            }

            C04351(Enumeration enumeration, File file, String str) {
                this.val$parent = enumeration;
                this.val$toolsJar = file;
                this.val$name = str;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return !this.first || this.val$parent.hasMoreElements();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Enumeration
            public URL nextElement() {
                if (!this.first) {
                    this.first = true;
                    try {
                        return new URL("jar:file:" + this.val$toolsJar.getAbsolutePath() + "!" + this.val$name);
                    } catch (MalformedURLException unused) {
                        return (URL) this.val$parent.nextElement();
                    }
                }
                return (URL) this.val$parent.nextElement();
            }
        }
    }

    private void runDirectly(List<String> args) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        Delombok.main((String[]) args.toArray(new String[0]));
    }

    private static File findToolsJar() {
        try {
            File toolsJar = findToolsJarViaRT();
            if (toolsJar != null) {
                return toolsJar;
            }
        } catch (Throwable unused) {
        }
        try {
            File toolsJar2 = findToolsJarViaProperties();
            if (toolsJar2 != null) {
                return toolsJar2;
            }
        } catch (Throwable unused2) {
        }
        try {
            return findToolsJarViaEnvironment();
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static File findToolsJarViaEnvironment() {
        for (Map.Entry<String, String> s2 : System.getenv().entrySet()) {
            if ("JAVA_HOME".equalsIgnoreCase(s2.getKey())) {
                return extensiveCheckToolsJar(new File(s2.getValue()));
            }
        }
        return null;
    }

    private static File findToolsJarViaProperties() {
        File home = new File(System.getProperty("java.home", "."));
        return extensiveCheckToolsJar(home);
    }

    private static File extensiveCheckToolsJar(File base) {
        File toolsJar = checkToolsJar(base);
        if (toolsJar != null) {
            return toolsJar;
        }
        File toolsJar2 = checkToolsJar(new File(base, "lib"));
        if (toolsJar2 != null) {
            return toolsJar2;
        }
        File toolsJar3 = checkToolsJar(new File(base.getParentFile(), "lib"));
        if (toolsJar3 != null) {
            return toolsJar3;
        }
        File toolsJar4 = checkToolsJar(new File(new File(base, "jdk"), "lib"));
        if (toolsJar4 != null) {
            return toolsJar4;
        }
        return null;
    }

    private static File findToolsJarViaRT() {
        String url;
        int idx;
        String url2 = ClassLoader.getSystemClassLoader().getResource("java/lang/String.class").toString();
        if (!url2.startsWith("jar:file:") || (idx = (url = url2.substring("jar:file:".length())).indexOf(33)) == -1) {
            return null;
        }
        String url3 = url.substring(0, idx);
        File toolsJar = checkToolsJar(new File(url3).getParentFile());
        if (toolsJar != null) {
            return toolsJar;
        }
        File toolsJar2 = checkToolsJar(new File(new File(url3).getParentFile().getParentFile().getParentFile(), "lib"));
        if (toolsJar2 != null) {
            return toolsJar2;
        }
        return null;
    }

    private static File checkToolsJar(File d) {
        if (d.getName().equals("tools.jar") && d.isFile() && d.canRead()) {
            return d;
        }
        File d2 = new File(d, "tools.jar");
        if (d2.getName().equals("tools.jar") && d2.isFile() && d2.canRead()) {
            return d2;
        }
        return null;
    }

    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "delombok";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("unlombok");
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Applies lombok transformations without compiling your\njava code (so, 'unpacks' lombok annotations and such).";
    }
}
