package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildIntegration;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ d(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelGuildIntegration) this.a.parse(new ModelGuildIntegration());
    }
}
