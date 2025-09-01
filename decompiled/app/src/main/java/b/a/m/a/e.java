package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelWebhook;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ e(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelWebhook) this.a.parse(new ModelWebhook());
    }
}
