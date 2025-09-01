package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/emoji/Emoji;", "emoji", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$EmojiItem;", "invoke", "(Lcom/discord/models/domain/emoji/Emoji;)Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$EmojiItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$buildEmojiListItems$items$2 extends Lambda implements Function1<Emoji, WidgetEmojiAdapter.EmojiItem> {
    public final /* synthetic */ boolean $allowEmojisToAnimate;
    public final /* synthetic */ Function1 $getGuild;
    public final /* synthetic */ String $searchInputLower;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$buildEmojiListItems$items$2(String str, Function1 function1, boolean z2) {
        super(1);
        this.$searchInputLower = str;
        this.$getGuild = function1;
        this.$allowEmojisToAnimate = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEmojiAdapter.EmojiItem invoke(Emoji emoji) {
        return invoke2(emoji);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEmojiAdapter.EmojiItem invoke2(Emoji emoji) {
        String name;
        Object next;
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        List<String> names = emoji.getNames();
        Intrinsics3.checkNotNullExpressionValue(names, "emoji.names");
        Iterator<T> it = names.iterator();
        while (true) {
            name = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String str = (String) next;
            Intrinsics3.checkNotNullExpressionValue(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) this.$searchInputLower, false, 2, (Object) null)) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 == null) {
            return null;
        }
        ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) (!(emoji instanceof ModelEmojiCustom) ? null : emoji);
        if (modelEmojiCustom != null) {
            Guild guild = (Guild) this.$getGuild.invoke(Long.valueOf(modelEmojiCustom.getGuildId()));
            if (guild != null) {
                name = guild.getName();
            }
        }
        return new WidgetEmojiAdapter.EmojiItem(name, emoji, str2, this.$allowEmojisToAnimate);
    }
}
