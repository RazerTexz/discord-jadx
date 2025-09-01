package b.o.a;

import androidx.annotation.NonNull;
import b.o.a.m.Audio;
import b.o.a.m.AudioCodec;
import b.o.a.m.Control;
import b.o.a.m.Engine;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Grid;
import b.o.a.m.Hdr;
import b.o.a.m.Mode3;
import b.o.a.m.PictureFormat;
import b.o.a.m.Preview;
import b.o.a.m.VideoCodec;
import b.o.a.m.WhiteBalance;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraOptions.java */
/* renamed from: b.o.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CameraOptions {
    public Set<WhiteBalance> a = new HashSet(5);

    /* renamed from: b, reason: collision with root package name */
    public Set<Facing> f1911b = new HashSet(2);
    public Set<Flash> c = new HashSet(4);
    public Set<Hdr> d = new HashSet(2);
    public Set<Size3> e = new HashSet(15);
    public Set<Size3> f = new HashSet(5);
    public Set<AspectRatio2> g = new HashSet(4);
    public Set<AspectRatio2> h = new HashSet(3);
    public Set<PictureFormat> i = new HashSet(2);
    public Set<Integer> j = new HashSet(2);
    public boolean k;
    public boolean l;
    public float m;
    public float n;
    public boolean o;
    public float p;
    public float q;

    @NonNull
    public final Collection<Facing> a() {
        return Collections.unmodifiableSet(this.f1911b);
    }

    @NonNull
    public final Collection<Flash> b() {
        return Collections.unmodifiableSet(this.c);
    }

    public final boolean c(@NonNull Control control) {
        Class<?> cls = control.getClass();
        return (cls.equals(Audio.class) ? Arrays.asList(Audio.values()) : cls.equals(Facing.class) ? a() : cls.equals(Flash.class) ? b() : cls.equals(Grid.class) ? Arrays.asList(Grid.values()) : cls.equals(Hdr.class) ? Collections.unmodifiableSet(this.d) : cls.equals(Mode3.class) ? Arrays.asList(Mode3.values()) : cls.equals(VideoCodec.class) ? Arrays.asList(VideoCodec.values()) : cls.equals(AudioCodec.class) ? Arrays.asList(AudioCodec.values()) : cls.equals(WhiteBalance.class) ? Collections.unmodifiableSet(this.a) : cls.equals(Engine.class) ? Arrays.asList(Engine.values()) : cls.equals(Preview.class) ? Arrays.asList(Preview.values()) : cls.equals(PictureFormat.class) ? Collections.unmodifiableSet(this.i) : Collections.emptyList()).contains(control);
    }
}
