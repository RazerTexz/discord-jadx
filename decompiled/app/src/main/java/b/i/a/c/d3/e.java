package b.i.a.c.d3;

import b.i.a.c.d3.SpannedToHtmlConverter;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Comparator {
    public static final /* synthetic */ e j = new e();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        SpannedToHtmlConverter.c cVar = (SpannedToHtmlConverter.c) obj;
        SpannedToHtmlConverter.c cVar2 = (SpannedToHtmlConverter.c) obj2;
        int iCompare = Integer.compare(cVar2.f916b, cVar.f916b);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = cVar.c.compareTo(cVar2.c);
        return iCompareTo != 0 ? iCompareTo : cVar.d.compareTo(cVar2.d);
    }
}
