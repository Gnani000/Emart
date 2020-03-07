import { Category } from './category';

export interface SubCategory{
    subCategoryId: number,
    subCategoryName: string,
    subCategoryBrief: number,
    subCategoryGst: number,
    category: Category
}