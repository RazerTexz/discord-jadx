package com.discord.api.botuikit;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: TextComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/botuikit/TextStyleTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/botuikit/TextStyle;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.botuikit.TextStyleTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class TextComponent3 extends TypeAdapter<TextComponent2> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.api.botuikit.TextStyleTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TextComponent2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextComponent2.SMALL.ordinal()] = 1;
            iArr[TextComponent2.PARAGRAPH.ordinal()] = 2;
            iArr[TextComponent2.UNKNOWN.ordinal()] = 3;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public TextComponent2 read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 1) ? TextComponent2.SMALL : (numN1 != null && numN1.intValue() == 2) ? TextComponent2.PARAGRAPH : TextComponent2.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, TextComponent2 textComponent2) throws IOException {
        Integer num;
        TextComponent2 textComponent22 = textComponent2;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (textComponent22 != null) {
            int iOrdinal = textComponent22.ordinal();
            if (iOrdinal == 0) {
                num = 1;
            } else if (iOrdinal == 1) {
                num = 2;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                num = null;
            }
            jsonWriter.D(num);
        }
    }
}
