package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelUserRelationship;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ x(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelUserRelationship) this.a.parse(new ModelUserRelationship());
    }
}
