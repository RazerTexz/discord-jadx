package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelPayload;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ ModelPayload.VersionedModel a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Model.JsonReader f248b;

    public /* synthetic */ t(ModelPayload.VersionedModel versionedModel, Model.JsonReader jsonReader) {
        this.a = versionedModel;
        this.f248b = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.a.parseEntry(this.f248b);
    }
}
