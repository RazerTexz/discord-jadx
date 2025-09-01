package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ b(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelAuditLogEntry) this.a.parse(new ModelAuditLogEntry());
    }
}
