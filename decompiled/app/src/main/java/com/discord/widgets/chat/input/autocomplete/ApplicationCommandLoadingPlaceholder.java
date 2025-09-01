package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandLoadingPlaceholder;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "Lcom/discord/models/commands/Application;", "component1", "()Lcom/discord/models/commands/Application;", "application", "copy", "(Lcom/discord/models/commands/Application;)Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandLoadingPlaceholder;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/Application;", "getApplication", "<init>", "(Lcom/discord/models/commands/Application;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandLoadingPlaceholder extends Autocompletable {
    private final Application application;

    public ApplicationCommandLoadingPlaceholder() {
        this(null, 1, null);
    }

    public /* synthetic */ ApplicationCommandLoadingPlaceholder(Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application);
    }

    public static /* synthetic */ ApplicationCommandLoadingPlaceholder copy$default(ApplicationCommandLoadingPlaceholder applicationCommandLoadingPlaceholder, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandLoadingPlaceholder.application;
        }
        return applicationCommandLoadingPlaceholder.copy(application);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommandLoadingPlaceholder copy(Application application) {
        return new ApplicationCommandLoadingPlaceholder(application);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ApplicationCommandLoadingPlaceholder) && Intrinsics3.areEqual(this.application, ((ApplicationCommandLoadingPlaceholder) other).application);
        }
        return true;
    }

    public final Application getApplication() {
        return this.application;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return "";
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return Collections2.emptyList();
    }

    public int hashCode() {
        Application application = this.application;
        if (application != null) {
            return application.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandLoadingPlaceholder(application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }

    public ApplicationCommandLoadingPlaceholder(Application application) {
        super(null);
        this.application = application;
    }
}
