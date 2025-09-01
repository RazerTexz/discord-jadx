package b.i.c.l;

import b.i.c.q.Publisher;
import b.i.c.q.Subscriber2;
import b.i.c.t.Provider2;
import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: ComponentRuntime.java */
/* renamed from: b.i.c.l.k, reason: use source file name */
/* loaded from: classes3.dex */
public class ComponentRuntime4 extends AbstractComponentContainer {
    public static final /* synthetic */ int a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Component4<?>, Lazy2<?>> f1665b = new HashMap();
    public final Map<Class<?>, Lazy2<?>> c = new HashMap();
    public final Map<Class<?>, Lazy2<Set<?>>> d = new HashMap();
    public final EventBus2 e;

    public ComponentRuntime4(Executor executor, Iterable<ComponentRegistrar> iterable, Component4<?>... component4Arr) {
        Set<CycleDetector2> set;
        EventBus2 eventBus2 = new EventBus2(executor);
        this.e = eventBus2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component4.c(eventBus2, EventBus2.class, Subscriber2.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (Component4<?> component4 : component4Arr) {
            if (component4 != null) {
                arrayList.add(component4);
            }
        }
        HashMap map = new HashMap(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Component4 component42 = (Component4) it2.next();
            CycleDetector2 cycleDetector2 = new CycleDetector2(component42);
            Iterator it3 = component42.a.iterator();
            while (it3.hasNext()) {
                Class cls = (Class) it3.next();
                boolean z2 = !component42.b();
                CycleDetector3 cycleDetector3 = new CycleDetector3(cls, z2, null);
                if (!map.containsKey(cycleDetector3)) {
                    map.put(cycleDetector3, new HashSet());
                }
                Set set2 = (Set) map.get(cycleDetector3);
                if (!set2.isEmpty() && !z2) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(cycleDetector2);
            }
        }
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            for (CycleDetector2 cycleDetector22 : (Set) it4.next()) {
                for (Dependency2 dependency2 : cycleDetector22.a.f1662b) {
                    if ((dependency2.c == 0) && (set = (Set) map.get(new CycleDetector3(dependency2.a, dependency2.a(), null))) != null) {
                        for (CycleDetector2 cycleDetector23 : set) {
                            cycleDetector22.f1666b.add(cycleDetector23);
                            cycleDetector23.c.add(cycleDetector22);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it5 = map.values().iterator();
        while (it5.hasNext()) {
            hashSet.addAll((Set) it5.next());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it6 = hashSet.iterator();
        while (it6.hasNext()) {
            CycleDetector2 cycleDetector24 = (CycleDetector2) it6.next();
            if (cycleDetector24.a()) {
                hashSet2.add(cycleDetector24);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            CycleDetector2 cycleDetector25 = (CycleDetector2) hashSet2.iterator().next();
            hashSet2.remove(cycleDetector25);
            i++;
            for (CycleDetector2 cycleDetector26 : cycleDetector25.f1666b) {
                cycleDetector26.c.remove(cycleDetector25);
                if (cycleDetector26.a()) {
                    hashSet2.add(cycleDetector26);
                }
            }
        }
        if (i != arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                CycleDetector2 cycleDetector27 = (CycleDetector2) it7.next();
                if (!cycleDetector27.a() && !cycleDetector27.f1666b.isEmpty()) {
                    arrayList2.add(cycleDetector27.a);
                }
            }
            throw new DependencyCycleException(arrayList2);
        }
        Iterator it8 = arrayList.iterator();
        while (it8.hasNext()) {
            Component4<?> component43 = (Component4) it8.next();
            this.f1665b.put(component43, new Lazy2<>(new ComponentRuntime(this, component43)));
        }
        for (Map.Entry<Component4<?>, Lazy2<?>> entry : this.f1665b.entrySet()) {
            Component4<?> key = entry.getKey();
            if (key.b()) {
                Lazy2<?> value = entry.getValue();
                Iterator<Class<? super Object>> it9 = key.a.iterator();
                while (it9.hasNext()) {
                    this.c.put(it9.next(), value);
                }
            }
        }
        for (Component4<?> component44 : this.f1665b.keySet()) {
            for (Dependency2 dependency22 : component44.f1662b) {
                if ((dependency22.f1668b == 1) && !this.c.containsKey(dependency22.a)) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component44, dependency22.a));
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<Component4<?>, Lazy2<?>> entry2 : this.f1665b.entrySet()) {
            Component4<?> key2 = entry2.getKey();
            if (!key2.b()) {
                Lazy2<?> value2 = entry2.getValue();
                for (Class<? super Object> cls2 : key2.a) {
                    if (!map2.containsKey(cls2)) {
                        map2.put(cls2, new HashSet());
                    }
                    ((Set) map2.get(cls2)).add(value2);
                }
            }
        }
        for (Map.Entry entry3 : map2.entrySet()) {
            this.d.put((Class) entry3.getKey(), new Lazy2<>(new ComponentRuntime2((Set) entry3.getValue())));
        }
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Provider2<T> b(Class<T> cls) {
        Objects.requireNonNull(cls, "Null interface requested.");
        return this.c.get(cls);
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Provider2<Set<T>> c(Class<T> cls) {
        Lazy2<Set<?>> lazy2 = this.d.get(cls);
        return lazy2 != null ? lazy2 : ComponentRuntime3.a;
    }
}
