package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.ChannelUtils;
import com.discord.models.commands.Application;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompletableComparator;", "Ljava/util/Comparator;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lkotlin/Comparator;", "o1", "o2", "", "compare", "(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AutocompletableComparator implements Comparator<Autocompletable> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Autocompletable autocompletable, Autocompletable autocompletable2) {
        return compare2(autocompletable, autocompletable2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Autocompletable o1, Autocompletable o2) {
        Intrinsics3.checkNotNullParameter(o1, "o1");
        Intrinsics3.checkNotNullParameter(o2, "o2");
        if (!Intrinsics3.areEqual(Reflection2.getOrCreateKotlinClass(o1.getClass()), Reflection2.getOrCreateKotlinClass(o2.getClass()))) {
            return Intrinsics3.compare(AutocompletableKt.getSortIndex(o1), AutocompletableKt.getSortIndex(o2));
        }
        if (o1 instanceof ApplicationCommandChoiceAutocompletable) {
            return AutocompletableKt.access$lower(((ApplicationCommandChoiceAutocompletable) o1).getChoice().getName()).compareTo(AutocompletableKt.access$lower(((ApplicationCommandChoiceAutocompletable) o2).getChoice().getName()));
        }
        if (o1 instanceof ApplicationCommandLoadingPlaceholder) {
            return 0;
        }
        if (o1 instanceof ApplicationCommandAutocompletable) {
            ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) o2;
            ApplicationCommandAutocompletable applicationCommandAutocompletable2 = (ApplicationCommandAutocompletable) o1;
            Application application = applicationCommandAutocompletable2.getApplication();
            Long lValueOf = application != null ? Long.valueOf(application.getId()) : null;
            Application application2 = applicationCommandAutocompletable.getApplication();
            if (Intrinsics3.areEqual(lValueOf, application2 != null ? Long.valueOf(application2.getId()) : null)) {
                return AutocompletableKt.access$lower(applicationCommandAutocompletable2.getCommand().getName()).compareTo(AutocompletableKt.access$lower(applicationCommandAutocompletable.getCommand().getName()));
            }
            Application application3 = applicationCommandAutocompletable2.getApplication();
            String strAccess$lower = AutocompletableKt.access$lower(String.valueOf(application3 != null ? application3.getName() : null));
            Application application4 = applicationCommandAutocompletable.getApplication();
            return strAccess$lower.compareTo(AutocompletableKt.access$lower(String.valueOf(application4 != null ? application4.getName() : null)));
        }
        if (o1 instanceof ApplicationPlaceholder) {
            return AutocompletableKt.access$lower(((ApplicationPlaceholder) o1).getApplication().getName()).compareTo(AutocompletableKt.access$lower(((ApplicationPlaceholder) o2).getApplication().getName()));
        }
        if (o1 instanceof ChannelAutocompletable) {
            ChannelAutocompletable channelAutocompletable = (ChannelAutocompletable) o2;
            ChannelAutocompletable channelAutocompletable2 = (ChannelAutocompletable) o1;
            String strAccess$lower2 = AutocompletableKt.access$lower(ChannelUtils.c(channelAutocompletable2.getChannel()));
            String strAccess$lower3 = AutocompletableKt.access$lower(ChannelUtils.c(channelAutocompletable.getChannel()));
            return Intrinsics3.areEqual(strAccess$lower2, strAccess$lower3) ^ true ? strAccess$lower2.compareTo(strAccess$lower3) : (channelAutocompletable2.getChannel().getId() > channelAutocompletable.getChannel().getId() ? 1 : (channelAutocompletable2.getChannel().getId() == channelAutocompletable.getChannel().getId() ? 0 : -1));
        }
        if (o1 instanceof EmojiAutocompletable) {
            String firstName = ((EmojiAutocompletable) o1).getEmoji().getFirstName();
            Intrinsics3.checkNotNullExpressionValue(firstName, "o1.emoji.firstName");
            String strAccess$lower4 = AutocompletableKt.access$lower(firstName);
            String firstName2 = ((EmojiAutocompletable) o2).getEmoji().getFirstName();
            Intrinsics3.checkNotNullExpressionValue(firstName2, "o2c.emoji.firstName");
            return strAccess$lower4.compareTo(AutocompletableKt.access$lower(firstName2));
        }
        if (o1 instanceof EmojiUpsellPlaceholder) {
            return 0;
        }
        if (o1 instanceof GlobalRoleAutocompletable) {
            return AutocompletableKt.access$lower(((GlobalRoleAutocompletable) o1).getText()).compareTo(AutocompletableKt.access$lower(((GlobalRoleAutocompletable) o2).getText()));
        }
        if (o1 instanceof RoleAutocompletable) {
            return AutocompletableKt.access$lower(((RoleAutocompletable) o1).getRole().getName()).compareTo(AutocompletableKt.access$lower(((RoleAutocompletable) o2).getRole().getName()));
        }
        if (!(o1 instanceof UserAutocompletable)) {
            throw new NoWhenBranchMatchedException();
        }
        UserAutocompletable userAutocompletable = (UserAutocompletable) o1;
        String nickname = userAutocompletable.getNickname();
        if (nickname == null) {
            nickname = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, userAutocompletable.getUser(), null, null, 3, null).toString();
        }
        UserAutocompletable userAutocompletable2 = (UserAutocompletable) o2;
        String nickname2 = userAutocompletable2.getNickname();
        if (nickname2 == null) {
            nickname2 = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, userAutocompletable2.getUser(), null, null, 3, null).toString();
        }
        return AutocompletableKt.access$lower(nickname).compareTo(AutocompletableKt.access$lower(nickname2));
    }
}
