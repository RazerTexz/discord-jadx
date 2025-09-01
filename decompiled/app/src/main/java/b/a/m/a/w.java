package b.a.m.a;

import com.discord.api.user.User;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ w(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (User) InboundGatewayGsonParser.fromJson(this.a, User.class);
    }
}
