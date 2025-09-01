package b.a.m.a.h0;

import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.ModelEmojiUnicode;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ a(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelEmojiUnicode) this.a.parse(new ModelEmojiUnicode());
    }
}
