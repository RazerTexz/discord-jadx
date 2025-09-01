package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelNotificationSettings;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ k(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.a;
        int i = ModelNotificationSettings.FREQUENCY_ALL;
        return (ModelNotificationSettings.ChannelOverride) jsonReader.parse(new ModelNotificationSettings.ChannelOverride());
    }
}
