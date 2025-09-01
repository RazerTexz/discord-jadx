package b.a.x.a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ a(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.a.nextString(null);
    }
}
