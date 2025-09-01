package b.a.m.a;

import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ y(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (GuildJoinRequest) InboundGatewayGsonParser.fromJson(this.a, GuildJoinRequest.class);
    }
}
