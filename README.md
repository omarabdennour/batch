# RepositoryItemReader skipping items in Spring Batch V5 

Question:

I'm experiencing an issue with the RepositoryItemReader in my Spring Batch job where it is skipping items during the read process. I have configured the RepositoryItemReader with a specific paging size and aligned it with the chunk size of the step. However, some items are being skipped, and I'm unable to determine the root cause of the problem.

Here are the relevant details of my setup:

I'm using Spring Batch v5.

The RepositoryItemReader is reading data from a repository using the findByIsEnabled method.

I have set the pageSize of the RepositoryItemReader to the same value as the chunk size in the step definition. I have verified that there are no filters or conditions applied to the RepositoryItemReader that could exclude items.

The repository used by the RepositoryItemReader is transactional, and the methods called by the reader are executed within the same transaction. I have checked the data source for any inconsistencies or missing items that could cause skipping, but everything seems to be in order.

nearly half of pages are skipped (4961/1000) items ratio

<img src="https://i.stack.imgur.com/3IxUd.png" alt="image">

The example at the top works with the h2 embedded database, you can just run it and you can see the result.

I suspect there might be an issue with the pagination logic or some misconfiguration that causes the reader to skip the next page. I have reviewed the Spring Batch documentation and tried various configurations, but I couldn't identify the root cause of this behavior.

I read the answer <a href="[https://www.w3schools.com](https://stackoverflow.com/questions/26509971/spring-batch-jpapagingitemreader-why-some-rows-are-not-read](https://stackoverflow.com/questions/26509971/spring-batch-jpapagingitemreader-why-some-rows-are-not-read)">here</a> before i write the question , but I can't find the solution for my case .

Could someone please help me identify potential causes for this skipping behavior with the RepositoryItemReader? Any suggestions or insights would be greatly appreciated.

