package com.discord.utilities.contacts;

import android.content.Context;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: ContactsFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/contacts/ContactsFetcher;", "", "", "", "fetchContacts", "()Ljava/util/Set;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ContactsFetcher {
    private final Context context;

    public ContactsFetcher(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Set<String> fetchContacts() {
        ContactsProviderUtils contactsProviderUtils = ContactsProviderUtils.INSTANCE;
        return !contactsProviderUtils.hasContactPermissions(this.context) ? Sets5.emptySet() : contactsProviderUtils.getAllContactPhoneNumbers(this.context);
    }

    public final Context getContext() {
        return this.context;
    }
}
