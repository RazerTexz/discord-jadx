package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreUserSettings;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func6;
import rx.subjects.BehaviorSubject;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreEmoji$EmojiContext;", "emojiContext", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreEmoji$EmojiContext;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$observeStoreState$1<T, R> implements Func1<StoreEmoji.EmojiContext, Observable<? extends EmojiPickerViewModel.StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ BehaviorSubject $selectedCategoryItemIdSubject;
    public final /* synthetic */ StoreAccessibility $storeAccessibility;
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    /* compiled from: EmojiPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/discord/models/domain/emoji/EmojiSet;", "emojiSet", "Ljava/util/LinkedHashMap;", "", "Lcom/discord/models/guild/Guild;", "allGuilds", "", "searchInputString", "", "allowEmojisToAnimate", "reducedMotionEnabled", "selectedCategoryItemId", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/emoji/EmojiSet;Ljava/util/LinkedHashMap;Ljava/lang/String;ZZJ)Lcom/discord/widgets/chat/input/emoji/EmojiPickerViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<EmojiSet, LinkedHashMap<Long, Guild>, String, Boolean, Boolean, Long, EmojiPickerViewModel.StoreState> {
        public final /* synthetic */ StoreEmoji.EmojiContext $emojiContext;

        public AnonymousClass1(StoreEmoji.EmojiContext emojiContext) {
            this.$emojiContext = emojiContext;
        }

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ EmojiPickerViewModel.StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, Boolean bool, Boolean bool2, Long l) {
            return call(emojiSet, linkedHashMap, str, bool.booleanValue(), bool2.booleanValue(), l.longValue());
        }

        public final EmojiPickerViewModel.StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, boolean z2, boolean z3, long j) {
            Intrinsics3.checkNotNullParameter(linkedHashMap, "allGuilds");
            Intrinsics3.checkNotNullParameter(str, "searchInputString");
            if (emojiSet == null) {
                return EmojiPickerViewModel.StoreState.Uninitialized.INSTANCE;
            }
            StoreEmoji.EmojiContext emojiContext = this.$emojiContext;
            boolean z4 = z2 && !z3;
            Set<Emoji> set = emojiSet.favoriteEmoji;
            Intrinsics3.checkNotNullExpressionValue(set, "emojiSet.favoriteEmoji");
            return new EmojiPickerViewModel.StoreState.Emoji(emojiSet, emojiContext, linkedHashMap, str, z4, j, set);
        }
    }

    public EmojiPickerViewModel$Companion$observeStoreState$1(StoreEmoji storeEmoji, StoreGuildsSorted storeGuildsSorted, BehaviorSubject behaviorSubject, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility, BehaviorSubject behaviorSubject2) {
        this.$storeEmoji = storeEmoji;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$searchSubject = behaviorSubject;
        this.$storeUserSettings = storeUserSettings;
        this.$storeAccessibility = storeAccessibility;
        this.$selectedCategoryItemIdSubject = behaviorSubject2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends EmojiPickerViewModel.StoreState> call(StoreEmoji.EmojiContext emojiContext) {
        return call2(emojiContext);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiPickerViewModel.StoreState> call2(StoreEmoji.EmojiContext emojiContext) {
        return emojiContext == null ? new ScalarSynchronousObservable(EmojiPickerViewModel.StoreState.Uninitialized.INSTANCE) : Observable.f(this.$storeEmoji.getEmojiSet(emojiContext, true, true), this.$storeGuildsSorted.observeOrderedGuilds(), this.$searchSubject, StoreUserSettings.observeIsAnimatedEmojisEnabled$default(this.$storeUserSettings, false, 1, null), this.$storeAccessibility.observeReducedMotionEnabled(), this.$selectedCategoryItemIdSubject, new AnonymousClass1(emojiContext));
    }
}
