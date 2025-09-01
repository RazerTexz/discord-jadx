package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ a0(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return UserExperimentDto.Parser.parse(this.a);
    }
}
