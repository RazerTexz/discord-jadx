package b.a.m.a;

import com.discord.api.presence.Presence;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ q(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Presence) InboundGatewayGsonParser.fromJson(this.a, Presence.class);
    }
}
