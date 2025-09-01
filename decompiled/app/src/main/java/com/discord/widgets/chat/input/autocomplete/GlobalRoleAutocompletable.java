package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u001a\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "component1", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "copy", "(Ljava/lang/String;)Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "textMatchers", "Ljava/util/List;", "getTextMatchers", "<init>", "(Ljava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GlobalRoleAutocompletable extends Autocompletable {
    private final String text;
    private final List<String> textMatchers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy here$delegate = LazyJVM.lazy(GlobalRoleAutocompletable$Companion$here$2.INSTANCE);
    private static final Lazy everyone$delegate = LazyJVM.lazy(GlobalRoleAutocompletable$Companion$everyone$2.INSTANCE);

    /* compiled from: Autocompletable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\n\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable$Companion;", "", "Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", "everyone$delegate", "Lkotlin/Lazy;", "getEveryone", "()Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", ModelGuildMemberListUpdate.EVERYONE_ID, "here$delegate", "getHere", "here", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final GlobalRoleAutocompletable getEveryone() {
            Lazy lazyAccess$getEveryone$cp = GlobalRoleAutocompletable.access$getEveryone$cp();
            Companion companion = GlobalRoleAutocompletable.INSTANCE;
            return (GlobalRoleAutocompletable) lazyAccess$getEveryone$cp.getValue();
        }

        public final GlobalRoleAutocompletable getHere() {
            Lazy lazyAccess$getHere$cp = GlobalRoleAutocompletable.access$getHere$cp();
            Companion companion = GlobalRoleAutocompletable.INSTANCE;
            return (GlobalRoleAutocompletable) lazyAccess$getHere$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoleAutocompletable(String str) {
        super(null);
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.text = str;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + str);
    }

    public static final /* synthetic */ Lazy access$getEveryone$cp() {
        return everyone$delegate;
    }

    public static final /* synthetic */ Lazy access$getHere$cp() {
        return here$delegate;
    }

    public static /* synthetic */ GlobalRoleAutocompletable copy$default(GlobalRoleAutocompletable globalRoleAutocompletable, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globalRoleAutocompletable.text;
        }
        return globalRoleAutocompletable.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final GlobalRoleAutocompletable copy(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new GlobalRoleAutocompletable(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GlobalRoleAutocompletable) && Intrinsics3.areEqual(this.text, ((GlobalRoleAutocompletable) other).text);
        }
        return true;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return leadingIdentifier().getIdentifier() + this.text;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getText() {
        return this.text;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        return outline.J(outline.U("GlobalRoleAutocompletable(text="), this.text, ")");
    }
}
