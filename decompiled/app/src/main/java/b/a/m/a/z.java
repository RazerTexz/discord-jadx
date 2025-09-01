package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentDto;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ z(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return GuildExperimentDto.Parser.parse(this.a);
    }
}
