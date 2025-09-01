package com.discord.utilities.contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.core.content.ContextCompat;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: ContactsProviderUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/contacts/ContactsProviderUtils;", "", "Landroid/content/Context;", "ctx", "", "hasContactPermissions", "(Landroid/content/Context;)Z", "", "", "getAllContactPhoneNumbers", "(Landroid/content/Context;)Ljava/util/Set;", "number", "getOwnName", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "CONTACTS_PERMISSION", "Ljava/lang/String;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ContactsProviderUtils {
    private static final String CONTACTS_PERMISSION = "android.permission.READ_CONTACTS";
    public static final ContactsProviderUtils INSTANCE = new ContactsProviderUtils();

    private ContactsProviderUtils() {
    }

    public final Set<String> getAllContactPhoneNumbers(Context ctx) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        ContentResolver contentResolver = ctx.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("data4"));
                if (string != null) {
                    hashSet.add(string);
                }
            }
            cursorQuery.close();
        }
        return hashSet;
    }

    public final String getOwnName(Context ctx, String number) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        Intrinsics3.checkNotNullParameter(number, "number");
        ContentResolver contentResolver = ctx.getContentResolver();
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        Intrinsics3.checkNotNullExpressionValue(uriWithAppendedPath, "Uri.withAppendedPath(Pho…_URI, Uri.encode(number))");
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, new String[]{"display_name"}, null, null, null);
        if (cursorQuery != null) {
            Intrinsics3.checkNotNullExpressionValue(cursorQuery, "contentResolver.query(ur…ull, null) ?: return null");
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                if (string != null) {
                    return string;
                }
            }
            cursorQuery.close();
        }
        return null;
    }

    public final boolean hasContactPermissions(Context ctx) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        return ContextCompat.checkSelfPermission(ctx, CONTACTS_PERMISSION) == 0;
    }
}
