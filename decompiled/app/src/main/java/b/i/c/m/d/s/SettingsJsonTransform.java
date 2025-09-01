package b.i.c.m.d.s;

import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.s.h.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SettingsJsonTransform.java */
/* renamed from: b.i.c.m.d.s.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface SettingsJsonTransform {
    SettingsData a(SystemCurrentTimeProvider systemCurrentTimeProvider, JSONObject jSONObject) throws JSONException;
}
