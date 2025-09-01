package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildFolder;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ d0(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return ModelGuildFolder.Parser.INSTANCE.parse(this.a);
    }
}
