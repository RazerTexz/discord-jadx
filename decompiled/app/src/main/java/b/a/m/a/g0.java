package b.a.m.a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ g0(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.a.nextStringOrNull();
    }
}
