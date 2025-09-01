package b.a.m.a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ h(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelAuditLogEntry.Change) this.a.parse(new ModelAuditLogEntry.Change());
    }
}
