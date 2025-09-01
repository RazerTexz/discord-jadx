package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelSession;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ m(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelSession) this.a.parse(new ModelSession());
    }
}
