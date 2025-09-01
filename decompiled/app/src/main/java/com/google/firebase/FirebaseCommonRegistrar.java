package com.google.firebase;

import android.content.Context;
import android.os.Build;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseCommonRegistrar2;
import b.i.c.FirebaseCommonRegistrar3;
import b.i.c.FirebaseCommonRegistrar4;
import b.i.c.FirebaseCommonRegistrar5;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.r.DefaultHeartBeatInfo2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.x.DefaultUserAgentPublisher;
import b.i.c.x.LibraryVersion;
import b.i.c.x.UserAgentPublisher;
import com.discord.widgets.chat.input.MentionUtils;
import d0.KotlinVersion;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace(MentionUtils.SLASH_CHAR, '_');
    }

    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        String string;
        ArrayList arrayList = new ArrayList();
        Component4.b bVarA = Component4.a(UserAgentPublisher.class);
        bVarA.a(new Dependency2(LibraryVersion.class, 2, 0));
        bVarA.c(DefaultUserAgentPublisher.a);
        arrayList.add(bVarA.b());
        Component4.b bVarA2 = Component4.a(HeartBeatInfo.class);
        bVarA2.a(new Dependency2(Context.class, 1, 0));
        bVarA2.c(DefaultHeartBeatInfo2.a);
        arrayList.add(bVarA2.b());
        arrayList.add(f.N("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(f.N("fire-core", "19.4.0"));
        arrayList.add(f.N("device-name", a(Build.PRODUCT)));
        arrayList.add(f.N("device-model", a(Build.DEVICE)));
        arrayList.add(f.N("device-brand", a(Build.BRAND)));
        arrayList.add(f.b0("android-target-sdk", FirebaseCommonRegistrar2.a));
        arrayList.add(f.b0("android-min-sdk", FirebaseCommonRegistrar3.a));
        arrayList.add(f.b0("android-platform", FirebaseCommonRegistrar4.a));
        arrayList.add(f.b0("android-installer", FirebaseCommonRegistrar5.a));
        try {
            string = KotlinVersion.j.toString();
        } catch (NoClassDefFoundError unused) {
            string = null;
        }
        if (string != null) {
            arrayList.add(f.N("kotlin", string));
        }
        return arrayList;
    }
}
