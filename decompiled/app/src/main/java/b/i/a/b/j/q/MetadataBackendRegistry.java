package b.i.a.b.j.q;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MetadataBackendRegistry.java */
/* renamed from: b.i.a.b.j.q.k, reason: use source file name */
/* loaded from: classes3.dex */
public class MetadataBackendRegistry implements BackendRegistry {
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final CreationContextFactory f776b;
    public final Map<String, TransportBackend> c;

    /* compiled from: MetadataBackendRegistry.java */
    /* renamed from: b.i.a.b.j.q.k$a */
    public static class a {
        public final Context a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f777b = null;

        public a(Context context) {
            this.a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BackendFactory a(String str) throws PackageManager.NameNotFoundException {
            Bundle bundle;
            Map<String, String> mapEmptyMap;
            PackageManager packageManager;
            if (this.f777b == null) {
                Context context = this.a;
                try {
                    packageManager = context.getPackageManager();
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.w("BackendRegistry", "Application info not found.");
                }
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                        if (bundle != null) {
                            Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                            mapEmptyMap = Collections.emptyMap();
                        } else {
                            HashMap map = new HashMap();
                            for (String str2 : bundle.keySet()) {
                                Object obj = bundle.get(str2);
                                if ((obj instanceof String) && str2.startsWith("backend:")) {
                                    for (String str3 : ((String) obj).split(",", -1)) {
                                        String strTrim = str3.trim();
                                        if (!strTrim.isEmpty()) {
                                            map.put(strTrim, str2.substring(8));
                                        }
                                    }
                                }
                            }
                            mapEmptyMap = map;
                        }
                        this.f777b = mapEmptyMap;
                    }
                }
                bundle = null;
                if (bundle != null) {
                }
                this.f777b = mapEmptyMap;
            }
            String str4 = this.f777b.get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str4).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str4), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str4), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str4), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str4), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str4), e5);
                return null;
            }
        }
    }

    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        a aVar = new a(context);
        this.c = new HashMap();
        this.a = aVar;
        this.f776b = creationContextFactory;
    }

    @Override // b.i.a.b.j.q.BackendRegistry
    @Nullable
    public synchronized TransportBackend get(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        BackendFactory backendFactoryA = this.a.a(str);
        if (backendFactoryA == null) {
            return null;
        }
        CreationContextFactory creationContextFactory = this.f776b;
        TransportBackend transportBackendCreate = backendFactoryA.create(new AutoValue_CreationContext(creationContextFactory.a, creationContextFactory.f774b, creationContextFactory.c, str));
        this.c.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
