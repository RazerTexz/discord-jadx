package b.a.m.a.h0;

import android.os.Parcelable;
import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.ModelEmojiUnicode;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    public /* synthetic */ c(Model.JsonReader jsonReader) {
        this.a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.a;
        Parcelable.Creator<ModelEmojiUnicode> creator = ModelEmojiUnicode.CREATOR;
        return jsonReader.nextString(null);
    }
}
