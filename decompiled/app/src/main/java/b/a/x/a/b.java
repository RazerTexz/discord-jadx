package b.a.x.a;

import com.discord.models.domain.Model;
import com.discord.utilities.error.Error;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ b(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Error.SkemaErrorItem) this.a.parse(new Error.SkemaErrorItem(null));
    }
}
