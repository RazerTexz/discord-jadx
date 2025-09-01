package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelCall;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ i(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.a;
        int i = ModelCall.j;
        return Long.valueOf(jsonReader.nextLong(1L));
    }
}
