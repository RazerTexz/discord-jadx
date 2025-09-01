package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements Model.JsonReader.KeySelector {
    public static final /* synthetic */ f0 a = new f0();

    @Override // com.discord.models.domain.Model.JsonReader.KeySelector
    public final Object get(Object obj) {
        return Long.valueOf(((UserExperimentDto) obj).getNameHash());
    }
}
